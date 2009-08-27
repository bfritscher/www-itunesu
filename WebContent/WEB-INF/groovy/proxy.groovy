if(request.getParameter("url")){
	def url = request.getParameter("url")
	def conn = url.toURL().openConnection()
	conn.setRequestProperty ( "User-Agent", "iTunes/8.1" )
	conn.getHeaderFields()
	response.sendRedirect( ( conn.getURL() =~ /http:\/\/deimos3.apple.com\/DeliverPreview/).replaceFirst("http:/") )	
} else {
	println "please provide an url parameter"
}




