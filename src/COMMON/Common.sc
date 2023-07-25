theme: /commonQuestions
    
    state: Greeting
        q!: [$exchInterjection/да] {[$exchBotSg/ты/тебе/те/вам] (привет/здрасьте/здравствуй*)} [уже/же/ж]
        q!: [$exchInterjection/да] {$exchGoodAdjNomMNt (утро/день/вечер)}
        q!: [$exchInterjection/да] (доброй ночи/$exchGoodAdjGenMNt (утра/дня/вечера/времени суток))
        go!: /goAnsCommon/Ans4_Greeting
        
        
    state: Wanna_Exchange
        q!: хочу обменять валюту
        q!: обмен
        go!: /goAnsCommon/Ans_Exchanging_All
        
    state: Exchange_X_to_X
        q!: обменять 100 долларов 
        go!: /goAnsCommon/Ans_Exchanging
        
    state: Currency_Exchange_Rate
        q!: курс валют
        go!: /goAnsCommon/Ans_Currency_Exch_Rate
        
    state: My_name_is
        q!: * меня зовут $Name *
        script:
            $session.name = $parseTree._Name.name;
        a: Привет, {{$session.name}}!
        
    state: Test_scripts
        q!: script
        script: 
            var rate = 102.5;
        a: переменная {{rate}}.