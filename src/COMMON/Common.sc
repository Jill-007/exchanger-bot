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
        
    state: Hello
        q!: * меня зовут $Name *
        script:
            $session.name = $parseTree._Name.name;
        a: Привет, {{$session.name}}!
        
    state: SumTwoNumbers
        q!: * [чему равно] @duckling.number::numberOne (плюс/$regex<\+>) @duckling.number::numberTwo *
        SumTwoNumbers:
            numberOne = {{$parseTree._numberOne}}
            numberTwo = {{$parseTree._numberTwo}}
        a: Посчитать для вас что-нибудь еще?