
import groovy.json.*

import org.apache.http.client.*
import org.apache.http.client.methods.*
import org.apache.http.entity.*
import org.apache.http.impl.client.*

// build JSON

Map<String,String> map = new HashMap<>() 
map["name"] = "Maritime DevCon"
map["address"] = "Fredericton"
map["handle"] = "maritimedevcon"

String jsonBody = new JsonBuilder(map).toString()

// build HTTP POST

String url = "http://jsonplaceholder.typicode.com/posts"
HttpPost post = new HttpPost(url)

post.addHeader("content-type", "application/json")
post.setEntity(new StringEntity(jsonBody))

// execute POST 

CloseableHttpClient client = HttpClientBuilder.create().build()
CloseableHttpResponse response = client.execute(post)
 
// check response

BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
String jsonResponse = bufferedReader.getText()
System.out.println("response: \n" + jsonResponse)

JsonSlurper slurper = new JsonSlurper()
Map resultMap = slurper.parseText(jsonResponse)

assert "Maritime DevCon" == resultMap["name"]
assert resultMap["id"] != null

