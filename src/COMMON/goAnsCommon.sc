theme: /goAnsCommon
    
    state: Ans4_Greeting
        a: Приветствую!
        
    state: Ans_Exchanging_All
        a: Введите сумму и валюту.
        
        state: react_Exchanging
            a: 100 долларов
            go: Ans_Exchanging
        
    state: Ans_Exchanging
       script:
            var exch_var = fx.convert(12.99, {from: "USD", to: "RUB"});
            return $reaction.answer("Это будет {{exch_var}} рублей.");
            
    state: Ans_Currency_Exch_Rate
        a: Актуальный находится на сайте <a href="https://www.cbr.ru/currency_base/daily/" target="_blank">Банка России</a>. 
