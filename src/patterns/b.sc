patterns:
    #exchBotSg - бот, голосовой помощник, оператор
    $exchBotSg = (
        $regexp<бо+т>/
        $regexp<г[ао]л[ао]с[ао]в(ой|ая)> $regexp<п[ао]мо[щш]ни[кц]а?>/
        $regexp<[оа]п[еи]рато?р>
        )
