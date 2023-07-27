var USD_value = null
var EUR_value = null

function httpGetAsync(id)
{
    log("trying to get http")
    var response = $http.get("https://www.cbr-xml-daily.ru/daily_utf8.xml");
    if (response.isOk) {
        var ls = response.data.ValCurs.Valute;
        for (var i=0; i<ls.length; i++){
            if (ls[i]==undefined) {
                continue
            }
            if (ls[i].ID == id) {
                return ls[i].Value
            }
        }
        // $temp.degree = response.data.current.temperature;
    }
    log("got http")
}
