function initPage()
{
	createApplet();
}


function reinitApplet()
{
	if(document.getElementById('appletMain'))
	{
		var spanApplet=document.getElementById('_applet');
		var spanAppletChild=spanApplet.childNodes[0];
		spanApplet.removeChild(spanAppletChild);
	}

	createApplet();
}

function createApplet()
{
	var _applet=document.createElement("applet");
	_applet.setAttribute("code", "StringOpsApplet.class");
	_applet.setAttribute("width", "500");
	_applet.setAttribute("height", "350");
	_applet.setAttribute("alt", "If your browser was ActiveX or Java-enabled, you could have performed certain operations on a string of your choice with this applet");
	_applet.setAttribute("id", "appletMain");
	_applet.innerHTML="<param name='usrInput' value='"+document.getElementById('usrInputString').value+"'>";
	document.getElementById("_applet").appendChild(_applet);
}


