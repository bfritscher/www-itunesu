import xmlwise.*

def getXml(item){
	def outputBuilder = new StreamingMarkupBuilder()
	outputBuilder.encoding = "UTF-8"
}

def xml

conn.setRequestProperty ( "User-Agent", "iTunes/8.1" )
def putBackTogether = new StringBuffer()
def r = new InputStreamReader ( conn.getInputStream(), "UTF-8" )
char [  ]  cb = new char [ 2048 ]
int amtRead = r.read ( cb )
while  ( amtRead  >  0 )   {  
    putBackTogether.append ( cb, 0, amtRead )
    amtRead = r.read ( cb )
 }
xml = putBackTogether.toString (  )

println """<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">"""

html.html(xmlns:"http://www.w3.org/1999/xhtml",lang:"en",'xml:lang':"en") {
	head {
		title xml.Path.PathElement.collect{it.'@displayName'}.join(" > ")
		meta('http-equiv':"X-UA-Compatible", content:"IE=8")
		meta('http-equiv':"content-type",content:"application/xhtml+xml; charset=UTF-8")
	}
	body(style:"background: #${xml.'*'.find{ it.'@backColor' != ''}.'@backColor'}"){
	} //body
}