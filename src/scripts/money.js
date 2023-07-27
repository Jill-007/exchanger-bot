var USD_value = null
var EUR_value = null

function httpGetAsync(theUrl, callback)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            callback(xmlHttp.responseText);
    }
    xmlHttp.open("GET", theUrl, true); // true for asynchronous 
    xmlHttp.send(null);
}

function USD(resp) {

  resp = ( new window.DOMParser() ).parseFromString(resp, "text/xml");

  valutes = resp.getElementsByTagName("Valute")
  for (var i = 0; i<=valutes.length; i++) {
    if (valutes[i] == undefined) {
      continue;
    }
    if (valutes[i].getAttribute("ID") == "R01235") {
      USD_value = valutes[i].getElementsByTagName("Value")[0].childNodes[0].nodeValue;
    }
  }

}

function EUR(resp) {

  resp = ( new window.DOMParser() ).parseFromString(resp, "text/xml");

  valutes = resp.getElementsByTagName("Valute")
  for (var i = 0; i<=valutes.length; i++) {
    if (valutes[i] == undefined) {
      continue;
    }
    if (valutes[i].getAttribute("ID") == "R01239") {
      EUR_value = valutes[i].getElementsByTagName("Value")[0].childNodes[0].nodeValue;
    }
  }

}

function get() {
    var response = $http.get("https://www.cbr-xml-daily.ru/daily_utf8.xml");
    if (response.isOk) {
        log(response)
        // $temp.degree = response.data.current.temperature;
    }
    // log("")
}