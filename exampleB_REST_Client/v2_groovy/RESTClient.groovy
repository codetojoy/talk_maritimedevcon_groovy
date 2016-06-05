
@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.2')

import groovy.json.*

import org.apache.http.client.methods.*
import org.apache.http.entity.*
import org.apache.http.impl.client.*

// build JSON

def map = [:]
map["name"] = "Maritime DevCon"
map["address"] = "Fredericton"
map["handle"] = "maritimedevcon"

def jsonBody = new JsonBuilder(map).toString()

// build HTTP POST

def url = 'http://jsonplaceholder.typicode.com/posts'
def post = new HttpPost(url)

post.addHeader("content-type", "application/json")
post.setEntity(new StringEntity(jsonBody))

// execute 

def client = HttpClientBuilder.create().build()
def response = client.execute(post)

def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
def jsonResponse = bufferedReader.getText()
println "response: \n" + jsonResponse

def slurper = new JsonSlurper()
def resultMap = slurper.parseText(jsonResponse)

assert "Maritime DevCon" == resultMap["name"]
assert resultMap["id"] != null

