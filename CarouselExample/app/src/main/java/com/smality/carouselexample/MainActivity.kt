package com.smality.carouselexample

import android.app.Activity
import android.content.res.Resources
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.*
import kotlin.math.abs

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        //Carousel Efektini Viewpager2 Ekleme
        viewPager.apply {
            clipChildren = false  // Sol ve sağ item'ları sayfada gösterme durumu
            clipToPadding = false  // viewpager item görüntülerken padding kullanma durumu
            offscreenPageLimit = 2
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER // Scroll effect silme
        }
        //Makale başlıkları
        val articleTitle = arrayListOf(
            "Compose Tasarım Araç ve Özellikleri",
            "Apk Uygulama İçi Güncelleme",
            "Android Compose’da Lazy Layout Kullanımı",
            "“Insecure Data Storage” Güvenlik Zafiyetleri",
            "Android View ile Compose Birlikte Kullanımı"
        )
        //Makale resimleri
        val articleImage=arrayListOf(R.drawable.composetooling,R.drawable.in_app_update,R.drawable.lazylayouts,R.drawable.android_security,R.drawable.interoperability_with_compose)

        viewPager.adapter = CarouselRVAdapter(articleTitle,articleImage)
        //Item'lar arasına biraz boşluk eklemek için MarginPageTransformer kullanalım...
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        viewPager.setPageTransformer(compositePageTransformer)
    }
}