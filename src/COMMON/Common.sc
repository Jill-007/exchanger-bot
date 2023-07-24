theme: /commonQuestions
    
    state: Greeting
        q!: [$exchInterjection/да] {[$exchBotSg/ты/тебе/те/вам] (привет/здрасьте/здравствуй*)} [уже/же/ж]
        q!: [$exchInterjection/да] {$exchGoodAdjNomMNt (утро/день/вечер)}
        q!: [$exchInterjection/да] (доброй ночи/$exchGoodAdjGenMNt (утра/дня/вечера/времени суток))
        go!: /goAnsCommon/Ans4_Greeting
        
        
    state: Wanna_Exchange
        q!: я хочу обменять валюту
        go!: /goAnsCommon/Ans_Exchanging_All
        
    state: Exchange_X_to_X
        q!: обменять 100 долларов 
        go!: /goAnsCommon/Ans_Exchanging