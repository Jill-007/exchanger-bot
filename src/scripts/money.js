var USD_value = null
var EUR_value = null

function httpGetAsync(theUrl, callback)
{
    log("trying to get http")
    var response = $http.get("https://www.cbr-xml-daily.ru/daily_utf8.xml");
    if (response.isOk) {
        var ls = response.data.ValCurs.Valute;
        for (var i=0; i<ls.length; i++){
            if (ls[i]==undefined) {
                continue
            }
            if (ls[i].ID == "R01235") {
                $USD_value = ls[i].Value;
            }
            log(ls[i].Value) 
        }
        // $temp.degree = response.data.current.temperature;
    }
    log("got http")
}

function USD(response) {

    var ls = response.data.ValCurs.Valute;
    for (var i=0; i<ls.length; i++){
        if (ls[i]==undefined) {
            continue
        }
        if (ls[i].ID == "R01235") {
            USD_value = ls[i].Value;
        }
        log(ls[i].Value) 
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
    log("trying to get http")
    var response = $http.get("https://www.cbr-xml-daily.ru/daily_utf8.xml");
    if (response.isOk) {
        var ls = response.data.ValCurs.Valute;
        for (var i=0; i<ls.length; i++){
            log(ls[i], i)   
        }
        // $temp.degree = response.data.current.temperature;
    }
    log("got http")
    // log("")
}