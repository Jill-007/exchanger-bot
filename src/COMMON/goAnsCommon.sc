theme: /goAnsCommon
    
    state: Ans4_Greeting
        a: Приветствую!
        
    state: Ans_Exchanging_All
        a: Введите сумму и валюту.
        
        state: Exchanging_Amount
            q: 100 долларов
            script:
                $reactions.transition("/goAnsCommon/Ans_Exchanging")
        
    state: Ans_Exchanging
        #script:
        #    var $client.exch_var = fx.(100).from("USD").to("RUB");
        #a: Это будет {{$client.exch_var}} рублей.
        a: Это будет 80. 000 рублей.
            
    state: Ans_Currency_Exch_Rate
        a: Актуальный находится на сайте <a href="https://www.cbr.ru/currency_base/daily/" target="_blank">Банка России</a>. 
