package com.annusza.bmicalc.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.annusza.bmicalc.R

class StatisticFragmentKot : Fragment() {

//    fun StatisticFragment() {}
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_statistic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myWebView = view.findViewById<View>(R.id.graph) as WebView
        val webSettings = myWebView.settings
        webSettings.javaScriptEnabled = true

        val graph = ("<html>\n"
                + "  <head>\n"
                + "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n"
                + "    <script type=\"text/javascript\">\n"
                + "      google.charts.load('current', {'packages':['bar']});\n"
                + "      google.charts.setOnLoadCallback(drawChart);\n"
                + "      function drawChart() {\n"
                + "var data = google.visualization.arrayToDataTable([\n"
                + " ['Country', 'Illnesses', 'Deaths', 'Cures'],\n"
                + " ['Poland',2420,36,7],\n"
                + "['USA', 190089, 4102, 7141],\n"
                + " ['Italy', 105792, 12428, 15729],\n"
                + " ['Spain', 102136, 9053, 22647],\n"
                + "  ['China', 82361, 3316, 2640],\n"
                + "  ['Germany', 74508, 821, 16100],\n"
                + "  ['France', 52836, 3532, 9522],\n"
                + " ['Iran', 47593, 3036, 15473],\n"
                + " ['United Kingdom', 29842, 2356, 179]\n"
                + " ]);\n"
                + "\n"
                + " var options = {\n"
                + " chart: {\n"
                + "  title: 'Statistics of SARS-CoV-2 by WHO',\n"
                + " subtitle: 'Country - illnesses, deaths and cures 1.04.2020',\n"
                + "  }\n"
                + "  };\n"
                + "\n"
                + "  var chart = new google.charts.Bar(document.getElementById('columnchart_material'));\n"
                + "  chart.draw(data, google.charts.Bar.convertOptions(options));\n"
                + " }\n"
                + "   </script>\n"
                + " </head>\n"
                + " <body>\n"
                + "  <div id=\"columnchart_material\" style=\"width: 800px; height: 500px;\"></div>\n"
                + "   </body>\n"
                + " </html>\n")
        myWebView.loadData(graph, "text/html", "UTF-8")
    }

}
