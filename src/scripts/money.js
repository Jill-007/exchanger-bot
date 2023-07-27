document.addEventListener('DOMContentLoaded', function() {
  var moneyjs = document.createElement('script');
  moneyjs.src = 'https://openexchangerates.github.io/money.js/money.min.js';
  document.body.appendChild(moneyjs);
  moneyjs.addEventListener('load', function() {
    fetch('https://www.cbr-xml-daily.ru/latest.js')
      .then(response => response.json())
      .then(function(data) {
        fx.rates = data.rates;
        fx.base = data.base;
    });
  });
});

var USD_value = Null
var EUR_value = Null

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