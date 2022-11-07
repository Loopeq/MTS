package com.example.mtsfinally.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mtsfinally.R
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView


class QRscaner : Fragment(), ZBarScannerView.ResultHandler {
    private lateinit var zBrView: ZBarScannerView

    override fun onStart() {
        super.onStart()
        zBrView = ZBarScannerView(context)


    }


    override fun handleResult(result: Result?) {

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QRscaner().apply {
                arguments = Bundle()
            }
    }


}