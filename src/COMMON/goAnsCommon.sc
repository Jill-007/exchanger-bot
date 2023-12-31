theme: /goAnsCommon
    
    state: Ans4_Greeting
        a: Приветствую!
        
    state: Ans_Exchanging
        script:
            $temp.quantity = $parseTree._Number;
            log("что в переменной кол-во: " + $temp.quantity);
            $temp.exch = httpGetAsync("R01235").replace(',', '.');
            log("курс доллара " + $temp.exch);
            $temp.calculated = $temp.quantity * $temp.exch;
            log("что посчитали? " + (Math.floor($temp.calculated * 10000) / 10000));
        a: {{$temp.quantity}} долларов по курсу {{$temp.exch}} будет {{Math.floor($temp.calculated * 10000) / 10000}} рублей! 
        
    state: Ans_Exchanging_All
        a: Какая валюта Вас интересует?
        buttons:
            "доллар" -> /goAnsCommon/Ans_Exchanging_USD
            "евро" -> /goAnsCommon/Ans_Exchanging_Euro
            "другая валюта" -> /goAnsCommon/Ans_Exchanging_Others
    
    state: Ans_Exchanging_USD
        script:
            var usd = httpGetAsync("R01235");
            $reactions.answer("Курс доллара на сегодня: " + usd);
        
    state: Ans_Exchanging_Euro
        script:
            var eur = httpGetAsync("R01239");
            $reactions.answer("Курс Евро на сегодня: " + eur);
        
    state: Ans_Exchanging_Others
        random:
            a: Меня пока не научили рассказывать про другие валюты, кроме доллара и евро. Актуальный курс Вы можете посмотреть сайте <a href="https://www.cbr.ru/currency_base/daily/" target="_blank">Банка России</a>.
            a: Я пока не знаю другие курсы кроме доллара и евро. Посмотрите актуальны курс на сайте <a href="https://www.cbr.ru/currency_base/daily/" target="_blank">Банка России</a>.
        
    state: Ans_Currency_Exch_Rate
        a: Актуальный находится на сайте <a href="https://www.cbr.ru/currency_base/daily/" target="_blank">Банка России</a>. 