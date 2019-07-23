package com.example.instakotlin.utils

import android.graphics.Bitmap
import androidx.fragment.app.FragmentActivity
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.instakotlin.R
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.FailReason
import com.nostra13.universalimageloader.core.assist.ImageScaleType
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener

class UniversalImageLoader(val mContext: FragmentActivity?) {


    val config:ImageLoaderConfiguration
    get() {

        val displayOptions = DisplayImageOptions.Builder()
            .showImageOnLoading(defaultImage) //
            .showImageForEmptyUri(defaultImage) // gelen url boş ise default resmi göstersin
            .showImageOnFail(defaultImage) // resim yüklenemez ise default resmi göstersin
            .cacheOnDisk(true).cacheInMemory(true)  // görselleri cache belleğe yüklesin ve gerektiğinde ordan çağırsın
            .cacheOnDisk(true).resetViewBeforeLoading(true) // yüklemeden öncede varolanı sıfırlasın
            .imageScaleType(ImageScaleType.EXACTLY) // görselleri geldiği gibi boyutlandırsın
            .displayer(FadeInBitmapDisplayer(400)) // görseller yüklenirken gözükecek efekt
            .build()

        return ImageLoaderConfiguration.Builder(mContext).defaultDisplayImageOptions(displayOptions).memoryCache(WeakMemoryCache())
            .diskCacheSize(100*1024*1024).build()


    }

    companion object{

        private val defaultImage = R.drawable.ic_profile

        fun setImage(imgUrl:String, imageView:ImageView, mProgressBar:ProgressBar?, ilkKisim:String?){

            val imageLoader = ImageLoader.getInstance()
            imageLoader.displayImage(ilkKisim+imgUrl,imageView, object : ImageLoadingListener{
                override fun onLoadingComplete(imageUri: String?, view: View?, loadedImage: Bitmap?) {


                    if (mProgressBar!=null){

                        mProgressBar.visibility = View.GONE
                    }

                }

                override fun onLoadingStarted(imageUri: String?, view: View?) {
                    if (mProgressBar!=null){

                        mProgressBar.visibility = View.VISIBLE
                    }                }

                override fun onLoadingCancelled(imageUri: String?, view: View?) {
                    if (mProgressBar!=null){

                        mProgressBar.visibility = View.GONE
                    }                }

                override fun onLoadingFailed(imageUri: String?, view: View?, failReason: FailReason?) {
                    if (mProgressBar!=null){

                        mProgressBar.visibility = View.GONE
                    }                }


            })
        }
    }
}