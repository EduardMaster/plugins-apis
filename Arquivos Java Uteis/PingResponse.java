package redwins.lobby.pl;

import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PingResponse {
	private InetSocketAddress host;
	private Gson gson;

	public PingResponse() {
		this.gson = new Gson();
	}

	public void setAddress(InetSocketAddress host) {
		this.host = host;
	}

	public InetSocketAddress getAddress() {
		return this.host;
	}

	public int readVarInt(DataInputStream in) throws IOException {
		int i = 0;
		int j = 0;
		int k;
		do {
			k = in.readByte();
			i |= (k & 0x7F) << j++ * 7;
			if (j > 5) {
				throw new RuntimeException("VarInt too big");
			}
		} while ((k & 0x80) == 128);
		return i;
	}

	public void writeVarInt(DataOutputStream out, int paramInt) throws IOException {
		for (;;) {
			if ((paramInt & 0xFFFFFF80) == 0) {
				out.writeByte(paramInt);
				return;
			}
			out.writeByte(paramInt & 0x7F | 0x80);
			paramInt >>>= 7;
		}
	}

	public StatusResponse fetchData() throws IOException {
		Socket socket = new Socket();

		socket.setSoTimeout(7000);

		socket.connect(this.host, 7000);

		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

		InputStream inputStream = socket.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream handshake = new DataOutputStream(b);
		handshake.writeByte(0);
		writeVarInt(handshake, 4);
		writeVarInt(handshake, this.host.getHostString().length());

		handshake.writeBytes(this.host.getHostString());
		handshake.writeShort(this.host.getPort());
		writeVarInt(handshake, 1);

		writeVarInt(dataOutputStream, b.size());
		dataOutputStream.write(b.toByteArray());

		dataOutputStream.writeByte(1);
		dataOutputStream.writeByte(0);
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		int size = readVarInt(dataInputStream);
		int id = readVarInt(dataInputStream);
		if (id == -1) {
			throw new IOException("Premature end of stream.");
		}
		if (id != 0) {
			throw new IOException("Invalid packetID");
		}
		int length = readVarInt(dataInputStream);
		if (length == -1) {
			throw new IOException("Premature end of stream.");
		}
		if (length == 0) {
			throw new IOException("Invalid string length.");
		}
		byte[] in = new byte[length];
		dataInputStream.readFully(in);
		String json = new String(in);

		long now = System.currentTimeMillis();
		dataOutputStream.writeByte(9);
		dataOutputStream.writeByte(1);
		dataOutputStream.writeLong(now);

		readVarInt(dataInputStream);
		id = readVarInt(dataInputStream);
		if (id == -1) {
			throw new IOException("Premature end of stream.");
		}
		if (id != 1) {
			throw new IOException("Invalid packetID");
		}
		long pingtime = dataInputStream.readLong();

		StatusResponse response = (StatusResponse) this.gson.fromJson(json, StatusResponse.class);

		dataOutputStream.close();
		outputStream.close();
		inputStreamReader.close();
		inputStream.close();
		socket.close();

		return response;
	}

	public class StatusResponse {
		private PingResponse.Players players;

		public StatusResponse() {
		}

		public PingResponse.Players getPlayers() {
			return this.players;
		}
	}

	public class Players {
		private int max;
		private int online;

		public Players() {
		}

		public int getMax() {
			return this.max;
		}

		public int getOnline() {
			return this.online;
		}
	}

}
