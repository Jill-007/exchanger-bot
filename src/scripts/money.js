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