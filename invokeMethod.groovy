/**
*  $groovyParam是字符串
*/
import groovy.json.JsonSlurper;
import groovy.json.JsonOutput;

def xmlSlr = new XmlSlurper().parseText($groovyParam);
def jsonSlr_obj = xmlSlr.interface.find{node -> node.@code == ""};
def json_cust = new JsonSlurper().parseText("$jsonSlr_obj");

//json_cust.object.result.flag = "1";
if("0".equals(json_cust.object.result.flag)){
    if(json_cust.object.result.desc.contains("！")){
        json_cust.object.result.desc = json_cust.object.result.desc.substring(0,json_cust.object.result.desc.lastIndexOf("！"));
    }
}

return JsonOutput.toJson(json_cust);