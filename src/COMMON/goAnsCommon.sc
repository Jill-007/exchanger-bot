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
            var money = []
            
    state: Ans_Currency_Exch_Rate
        a: Актуальный находится на сайте <a href="https://www.cbr.ru/currency_base/daily/" target="_blank">Банка России</a>. 
