require: slotfilling/slotFilling.sc
    module = sys.zb-common
    
require: name/name.sc
    module = sys.zb-common
    
require: floatNumber/floatNumber.sc
    module = sys.zb-common
  
#require: money.js
#    module = money.js

require: requireAll.sc


theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Undef
        event!: noMatch
        a: Sorry, I don’t understand.
        event: noMatch || toState = "/Undef_Ans/Undef"


    #state: Hello
    #    intent!: /привет
    #    a: Привет привет

    #state: Bye
    #    intent!: /пока
    #    a: Пока пока

    #state: NoMatch
    #    event!: noMatch
    #    a: Я не понял. Вы сказали: {{$request.query}}

    #state: Match
    #    event!: match
    #    a: {{$context.intent.answer}}