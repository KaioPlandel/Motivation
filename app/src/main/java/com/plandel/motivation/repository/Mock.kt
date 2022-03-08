package com.plandel.motivation.repository

import kotlin.random.Random

class Mock {
    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez."),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!"),
        Phrase("Quando está mais escuro, vemos mais estrelas!"),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente."),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado."),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?"),
        Phrase("A melhor maneira de prever o futuro é inventá-lo."),
        Phrase("Você perde todas as chances que você não aproveita."),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso."),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!"),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve."),
        Phrase("Se você acredita, faz toda a diferença."),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!")
    )

    fun getPhrase(): String {

        var rand = java.util.Random().nextInt(mListPhrases.size)
        return mListPhrases[rand].description
    }

}