theme: /goAnsCommon
    
    state: Ans4_Greeting
        a: Приветствую!
        
    state: Ans_Exchanging_All
        a: Введите сумму и валюту.
        
        state: react_Exchanging
            script:
                alert('hello')
            a: 100 долларов
            #script:
            #    return $reactions.transition("Ans_Exchanging");
        
    state: Ans_Exchanging
       script:
            var $exch_var = fx.(100).from("USD").to("RUB");
            return $reactions.answer("Это будет {{$exch_var}} рублей.");
            
    state: Ans_Currency_Exch_Rate
        a: Актуальный находится на сайте <a href="https://www.cbr.ru/currency_base/daily/" target="_blank">Банка России</a>. 
