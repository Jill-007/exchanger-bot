theme: /commonQuestions
    
    state: Greeting
        q!: [$exchInterjection/да] {[$exchBotSg/ты/тебе/те/вам] (привет/здрасьте/здравствуй*)} [уже/же/ж]
        q!: [$exchInterjection/да] {$exchGoodAdjNomGen ($exchMorningSg/$exchDaySg/$exchEveningSg)}
        q!: [$exchInterjection/да] $exchGoodAdjNomGen $exchNightSg
        go!: /goAnsCommon/Ans4_Greeting