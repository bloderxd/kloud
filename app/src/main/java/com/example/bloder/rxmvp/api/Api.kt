package com.example.bloder.rxmvp.api

import com.example.bloder.rxmvp.data.Food

/**
 * Created by bloder on 27/05/17.
 */

class Api {
    companion object {
        fun mockFoods(): List<Food> = listOf(
                Food("Hamburger", "https://www.designmaster.com.br/designmarketing/produtos/g_foto1_3246.jpg"),
                Food("Bread", "http://files.recipetips.com/kitchen/images/refimages/bread/types/Italian_bread_500.jpg"),
                Food("Cream Cracker", "http://4.bp.blogspot.com/-wEyLvzFcOwM/VVZP11heJ0I/AAAAAAAAS6s/E5mkTR2cFXg/s640/Cream%2BCracker.jpg"),
                Food("Olive", "http://www.pittedolives.it/img/Olive-Denocciolate.jpg"),
                Food("Potato", "http://img.aws.livestrongcdn.com/ls-article-image-673/ds-photo/getty/article/92/225/510060718_XS.jpg")
        )

        fun mockDesserts(): List<Food> = listOf(
                Food("Ice Cream", "https://www-tc.pbs.org/food/files/2012/07/History-of-Ice-Cream-1.jpg"),
                Food("Cake", "https://www.archiesonline.com/upload/product/large/Happy_Birthday_Choco_Cake_PRCAKE139_70abbd2d.jpg"),
                Food("Apple Pie", "http://food.fnr.sndimg.com/content/dam/images/food/fullset/2010/10/4/1/FNM_110110-Pies-027_s4x3.jpg.rend.hgtvcom.406.305.jpeg"),
                Food("Bubble Gum", "https://nuts.com/images/auto/510x340/assets/50d1e1af98a8a19c.jpg"),
                Food("Lollipop", "http://cdn.crossmap.com/images/2/22/22262.jpg")
        )
    }
}