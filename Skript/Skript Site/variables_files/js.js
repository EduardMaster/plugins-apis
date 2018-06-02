function filter_version(version){if(version){if(!/^\d+(\.\d+(\.\d+)?)?$/.test(version)){alert("Please enter a valid version number");return false;}
if(/^\d+$/.test(version))
version+=".0";}
var sections=document.getElementById("page").childNodes;for(var i=0;i<sections.length;i++){var since=get_data(sections[i],"since");if(since==null)
continue;sections[i].style.display=version&&since.localeCompare(version)>0?"none":"";}
return false;}
function section_edit(section){if(section.getAttribute("class").search(/\bediting\b/)!=-1)
return false;section.setAttribute("class",section.getAttribute("class")+" editing");var id=section.getElementsByTagName("a")[0].name;var name=section.getElementsByTagName("h2")[0];name.setAttribute("data-id","name");var description=get_data_node(section,"description");var usage=get_data_node(section,"usage");if(usage!=null&&usage.innerHTML=='<i>cannot be written in scripts</i>')
usage.innerHTML='';var since=get_data_node(section,"since");var examples=get_data_node(section,"examples");var single_lines=Array(name,since);var multi_lines=Array(description,usage,examples);for(var i=0;i<single_lines.length;i++){single_lines[i].innerHTML='<input name="'+single_lines[i].getAttribute("data-id")+'" type="text" value="'+single_lines[i].innerHTML+'"/>';}
for(var i=0;i<multi_lines.length;i++){var e=multi_lines[i];if(e==null)
continue;e.innerHTML='<textarea name="'+e.getAttribute("data-id")+'" style="width: '+(e==description?674:e.offsetWidth)+'px; height: '+e.offsetHeight+'px;" wrap="'+(e===examples?'off':'soft')+'" onkeypress="input(event);">'+e.innerHTML.replace(/\n?<br>\n?/g,"\n")+'</textarea>';}
section.innerHTML='<form method="post" action="./#'+id+'">'+section.innerHTML+'<input type="hidden" name="id" value="'+id+'"/><input type="submit" value="submit"/></form>';return false;}
function get_data(node,data_id){var node=get_data_node(node,data_id);return node==null?null:node.innerHTML;}
function get_data_node(node,data_id){if(node.nodeType!=Node.ELEMENT_NODE)
return null;if(node.getAttribute("data-id")===data_id)
return node;var children=node.childNodes;for(var i=0;i<children.length;i++){var d=get_data_node(children[i],data_id);if(d!=null)
return d;}
return null;}
function decrypt(string){var r='';var a=string.split(',');for(var i=0;i<a.length;i++){r=r.concat(String.fromCharCode((a[i]-5)/2));
}
return r;}
function input(event){var t=event.target;var ss=t.selectionStart;var se=t.selectionEnd;if(event.keyCode==9){if(event.altKey||event.ctrlKey)
return;event.preventDefault();var oldscroll=t.scrollTop;if(ss==se){if(!event.shiftKey){t.value=t.value.substring(0,ss)+"\t"+ t.value.substring(ss);t.selectionStart=t.selectionEnd=ss+ 1;}else{if(ss>0&&t.value.charAt(ss- 1)=="\t"){t.value=t.value.substring(0,ss- 1)+ t.value.substring(ss);t.selectionStart=t.selectionEnd=ss- 1;}}}else{ss=t.value.lastIndexOf("\n",ss)+ 1;se=t.value.indexOf("\n",se);if(se==-1)
se=t.value.length;var e=t.value.length- se;t.value=t.value.substring(0,ss)+(event.shiftKey?t.value.substring(ss,se).replace(/(^|\n)\t/g,"$1"):"\t"+ t.value.substring(ss,se).replace(/\n/g,"\n\t"))+ t.value.substring(se);t.selectionStart=ss;t.selectionEnd=t.value.length- e;}
t.scrollTop=oldscroll;}else if(event.keyCode==13){if(t.value.charAt(ss- 1)=="\n")
return;var ls=t.value.lastIndexOf("\n",ss- 1)+ 1;var nt=0;while(t.value.charAt(ls+ nt)=="\t")
nt++;if(nt>0){event.preventDefault();var oldscroll=t.scrollTop;t.value=t.value.substring(0,ss)+"\r\n"+ t.value.substring(ls,ls+ nt)+ t.value.substring(se);t.selectionStart=t.selectionEnd=ss+ 2;t.scrollTop=oldscroll;}}}