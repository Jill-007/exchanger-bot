#require: /scripts/money.js

theme: /commonQuestions
    
    state: Greeting
        q!: [$interjection/да] {[$botSg/ты/тебе/те/вам] (привет/здрасьте/здравствуй*)} [уже/же/ж]
        q!: [$interjection/да] {$goodAdjNomMNt (утро/день/вечер)}
        q!: [$interjection/да] (доброй ночи/$goodAdjGenMNt (утра/дня/вечера/времени суток))
        go!: /goAnsCommon/Ans4_Greeting
        
        
    state: Wanna_Exchange
        q!: хочу (обменять/поменять) валюту
        q!: мне (надо/нужно/хотелось бы) (обменять/поменять) валюту
        q!: обмен
        go!: /goAnsCommon/Ans_Exchanging_All
        
    state: Exchange_X_to_X
        q!: обменять $Number долларов 
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
   
    state: Experiment3
        q!: expm3
        script:
            var eur = httpGetAsync("R01239");
            var usd = httpGetAsync("R01235");
            log("а теперь через xml");
            $reactions.answer("EURO: "+eur+";\n"+"USD: "+usd);
        
        #//какой сегодня курс
        #//скажи курс/какой у нас курс сегодня/что говорят про курс сегодня/какой сегодня выставили курс
        #//а что за курс/что с курсом/по чем доллар сегодня/расскажи про курс/хочу поменять/обменять валюту/доллары/евро/деньги
        #//какой курс доллара на сегодняшний день
        #//какой курс евра на сегодняшний день
        #//доллары/баксы/зелень/американские деньги/рубли/франклины
        #//знаешь курс?