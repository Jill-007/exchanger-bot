#require: /scripts/money.js

theme: /commonQuestions
    
    state: Greeting
        q!: [$exchInterjection/да] {[$exchBotSg/ты/тебе/те/вам] (привет/здрасьте/здравствуй*)} [уже/же/ж]
        q!: [$exchInterjection/да] {$exchGoodAdjNomMNt (утро/день/вечер)}
        q!: [$exchInterjection/да] (доброй ночи/$exchGoodAdjGenMNt (утра/дня/вечера/времени суток))
        go!: /goAnsCommon/Ans4_Greeting
        
        
    state: Wanna_Exchange
        q!: хочу (обменять/поменять) валюту
        q!: мне (надо/нужно/хотелось бы) (обменять/поменять) валюту
        q!: обмен
        go!: /goAnsCommon/Ans_Exchanging_All
        
    state: Exchange_X_to_X
        q!: обменять 100 долларов 
        go!: /goAnsCommon/Ans_Exchanging
        
    state: Currency_Exchange_Rate
        q!: курс валют
        go!: /goAnsCommon/Ans_Currency_Exch_Rate
        
    state: My_name_is
        q!: * меня зовут $Imena *
        script:
            $session.name = $parseTree._Imena;
        a: Привет, {{capitalize($session.name)}}!
        
    state: Test_scripts
        q!: варс
        script: 
            var rate = 102.5;
            log("запоминаю переменную");
            $reactions.answer('переменная ' + rate);
            log("выдал ответ");
        
    state: Experiment2
        q!: expm2
        script:
            var exch2 = fx.convert(12.99, {from: "GBP", to: "HKD"});;
            log("что там с курсом фунт гонконг");
            $reactions.answer(exch2);
    
    state: Experiment
        q!: expm
        script:
            var exch = fx(100).from("USD").to("RUB");
            log("что там с курсом доллар рубль" + exch);
            $reactions.answer(exch);
    
    state: Experiment3
        q!: expm3
        script:
            eur = httpGetAsync("https://www.cbr-xml-daily.ru/daily_utf8.xml", "R01239");
            usd = httpGetAsync("https://www.cbr-xml-daily.ru/daily_utf8.xml", "R01235");
            log("а теперь через xml");
            $reactions.answer("EURO: "+eur+"; "+"USD: "+usd);
        
        #//какой сегодня курс
        #//скажи курс
        #//а что за курс/что с курсом/по чем доллар сегодня/расскажи про курс/хочу поменять/обменять валюту/доллары/евро/деньги
        #//какой курс доллара на сегодняшний день
        #//какой курс евра на сегодняшний день
        #//доллары/баксы/зелень/американские деньги/рубли/франклины