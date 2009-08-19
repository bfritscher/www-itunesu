if(request.getParameter("url")){
	def url = request.getParameter("url")
	def conn = "http://deimos.apple.com/WebObjects/Core.woa/DownloadRedirectedTrackPreview/unil.ch.2244181544.02244181550.2374720214.m4v".toURL().openConnection()
	conn.setRequestProperty ( "User-Agent", "iTunes/8.1" )
	conn.getHeaderFields()
	response.sendRedirect( ( conn.getURL() =~ /http:\/\/deimos3.apple.com\/DeliverPreview/).replaceFirst("http:/") )	
} else {
	println "please provide an url parameter"
}




