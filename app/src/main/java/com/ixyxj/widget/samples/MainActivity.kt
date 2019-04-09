package com.ixyxj.widget.samples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mathview_3.text = "When \$a \\ne 0$, there are two solutions to (ax^2 + bx + c = 0) and they are \$\$x = {-b \\pm \\sqrt{b^2-4ac} \\over 2a}.$$"
//        mathview_3.text = "When\n" +
//                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" +
//                "  <mi>a</mi><mo>&#x2260;</mo><mn>0</mn>\n" +
//                "</math>,\n" +
//                "there are two solutions to\n" +
//                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" +
//                "  <mi>a</mi><msup><mi>x</mi><mn>2</mn></msup>\n" +
//                "  <mo>+</mo> <mi>b</mi><mi>x</mi>\n" +
//                "  <mo>+</mo> <mi>c</mi> <mo>=</mo> <mn>0</mn>\n" +
//                "</math>\n" +
//                "and they are\n" +
//                "<math xmlns=\"http://www.w3.org/1998/Math/MathML\" display=\"block\">\n" +
//                "  <mi>x</mi> <mo>=</mo>\n" +
//                "  <mrow>\n" +
//                "    <mfrac>\n" +
//                "      <mrow>\n" +
//                "        <mo>&#x2212;</mo>\n" +
//                "        <mi>b</mi>\n" +
//                "        <mo>&#x00B1;</mo>\n" +
//                "        <msqrt>\n" +
//                "          <msup><mi>b</mi><mn>2</mn></msup>\n" +
//                "          <mo>&#x2212;</mo>\n" +
//                "          <mn>4</mn><mi>a</mi><mi>c</mi>\n" +
//                "        </msqrt>\n" +
//                "      </mrow>\n" +
//                "      <mrow> <mn>2</mn><mi>a</mi> </mrow>\n" +
//                "    </mfrac>\n" +
//                "  </mrow>\n" +
//                "  <mtext>.</mtext>\n" +
//                "</math>"
    }
}
