#require: /scripts/money.js

theme: /commonQuestions
    
    state: Greeting
        q!: [$interjection/да] {[$botSg/ты/тебе/те/вам] (привет/здрасьте/здравствуй*)} [уже/же/ж]
        q!: [$interjection/да] {$goodAdjNomMNt (утро/день/вечер)}
        q!: [$interjection/да] (доброй ночи/$goodAdjGenMNt (утра/дня/вечера/времени суток))
        go!: /goAnsCommon/Ans4_Greeting
        
        
    state: Wanna_Exchange
        q!: [какой/$pleaseIntj/$information] (курс/$about курсе)
        q!: хочу (обменять/поменять) валюту
        q!: мне (надо/нужно/хотелось бы) (обменять/поменять) валюту
        q!: обмен
        go!: /goAnsCommon/Ans_Exchanging_All
        
    state: Exchange_X_to_X
        q!: обменять $Number долларов 
        go!: /goAnsCommon/Ans_Exchanging
        
    state: Currency_Exchange_Rate
        q!: курс (валют/валюты)
        go!: /goAnsCommon/Ans_Currency_Exch_Rate
        
    state: USD_rate
        #какой курс доллара на сегодняшний день
        q!: [какой/$pleaseIntj/$information] {(курс/$about курсе) [какой/$pleaseIntj/$information] $Dollar} [какой/$pleaseIntj/$information]
        q!: * [какой] * {~курс $Dollar} * $todayNNom *
        q!: {курс (валют*/обмен*)} $Dollar
        q!: [у] $Dollar {курс (валют*/обмен*)}
        q!: * {$Dollar * ($todayNNom/$todayAdj)} *
        q!: * $change [наличн*] $Dollar *
        q!: * $Dollar [наличн*] $change *
        q!: * $wanna * $change * $Dollar *
        q!: * {($what/$whatA) * курс * $Dollar} * $todayNNom *
        q!: * $todayNNom * {($what/$whatA) * курс * $Dollar} *
        q!: * {$what * с курсом * $Dollar} * $todayNNom *
        q!: * $todayNNom * {$what * с курсом * $Dollar} *
        q!: * {курс $todayAdj} * $Dollar *
        q!: * {($howMuch/по чем/почем) * (стоит/берут за/покупают/купить) * $Dollar} *
        go!: /goAnsCommon/Ans_Exchanging_USD
        #//сколько стоит доллар
        
    state: Euro_rate
        #какой курс евро на сегодняшний день
        q!: [какой/$pleaseIntj/$information] {(курс/$about курсе) [какой/$pleaseIntj/$information] $Euro} [какой/$pleaseIntj/$information]
        q!: * [какой] * {~курс $Euro} * $todayNNom *
        q!: {курс (валют*/обмен*)} $Euro
        q!: [у] $Euro {курс (валют*/обмен*)}
        q!: * {$Euro * ($todayNNom/$todayAdj)} *
        q!: * $change [наличн*] $Euro *
        q!: * $Euro [наличн*] $change *
        q!: * $wanna * $change * $Euro *
        q!: * {($what/$whatA) * курс * $Euro} * $todayNNom *
        q!: * $todayNNom * {($what/$whatA) * курс * $Euro} *
        q!: * {$what * с курсом * $Euro} * $todayNNom *
        q!: * $todayNNom * {$what * с курсом * $Euro} *
        q!: * {курс $todayAdj} * $Euro *
        q!: * {($howMuch/по чем/почем) * (стоит/берут за/покупают/купить) * $Euro} *
        go!: /goAnsCommon/Ans_Exchanging_Euro
    
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