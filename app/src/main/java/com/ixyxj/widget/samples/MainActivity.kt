package com.ixyxj.widget.samples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ixyxj.widget.MathWebView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.findViewById<MathWebView>(R.id.mathview_3).text = mathml
    }

     var mathml = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\" display=\"block\" mathcolor=\"black\">\n" +
     "  <mrow>\n" +
     "    <mi>f</mi>\n" +
     "    <mrow>\n" +
     "      <mo>(</mo>\n" +
     "      <mi>a</mi>\n" +
     "      <mo>)</mo>\n" +
     "    </mrow>\n" +
     "  </mrow>\n" +
     "  <mo>=</mo>\n" +
     "  <mrow>\n" +
     "    <mfrac>\n" +
     "      <mn>1</mn>\n" +
     "      <mrow>\n" +
     "        <mn>2</mn>\n" +
     "        <mi>&#x3C0;</mi>\n" +
     "        <mi>i</mi>\n" +
     "      </mrow>\n" +
     "    </mfrac>\n" +
     "    <msub>\n" +
     "      <mo>&#x222E;</mo>\n" +
     "      <mrow>\n" +
     "        <mi>&#x3B3;</mi>\n" +
     "      </mrow>\n" +
     "    </msub>\n" +
     "    <mfrac>\n" +
     "      <mrow>\n" +
     "        <mi>f</mi>\n" +
     "        <mo>(</mo>\n" +
     "        <mi>z</mi>\n" +
     "        <mo>)</mo>\n" +
     "      </mrow>\n" +
     "      <mrow>\n" +
     "        <mi>z</mi>\n" +
     "        <mo>&#x2212;</mo>\n" +
     "        <mi>a</mi>\n" +
     "      </mrow>\n" +
     "    </mfrac>\n" +
     "    <mi>d</mi>\n" +
     "    <mi>z</mi>\n" +
     "  </mrow>\n" +
     "</math>"
}
