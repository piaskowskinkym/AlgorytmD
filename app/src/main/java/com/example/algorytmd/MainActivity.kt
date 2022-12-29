package com.example.algorytmd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
/*Edge(OdDo("a"), OdDo("b"), 4),
             Edge(OdDo("a"), OdDo("c"), 2),
             Edge(OdDo("b"), OdDo("c"), 3),
             Edge(OdDo("c"), OdDo("b"), 1),
             Edge(OdDo("c"), OdDo("d"), 5),
             Edge(OdDo("b"), OdDo("d"), 1),
             Edge(OdDo("a"), OdDo("e"), 1),
             Edge(OdDo("e"), OdDo("d"), 4)*/

data class OdDo(val s: String) : Node

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btnDijsktra = findViewById<Button>(R.id.btnSearch)
        var btnAdd = findViewById<Button>(R.id.btnAdd)
        var txt = findViewById<TextView>(R.id.txtResult)
        var sOrigin = findViewById<Spinner>(R.id.sOrigin)
        var sAppend = findViewById<Spinner>(R.id.sAppend)
        val graph = mutableListOf<Edge>()

        btnAdd.setOnClickListener {

            when (sOrigin.selectedItemPosition) {

                0 -> when (sAppend.selectedItemPosition) {
                    0 -> graph.add(Edge(OdDo("a"), OdDo("a"), 1))
                    1 -> graph.add(Edge(OdDo("a"), OdDo("b"), 1))
                    2 -> graph.add(Edge(OdDo("a"), OdDo("c"), 1))
                    3 -> graph.add(Edge(OdDo("a"), OdDo("d"), 1))
                    4 -> graph.add(Edge(OdDo("a"), OdDo("e"), 1))
                }
                1 -> when (sAppend.selectedItemPosition) {
                    0 -> graph.add(Edge(OdDo("b"), OdDo("a"), 1))
                    1 -> graph.add(Edge(OdDo("b"), OdDo("b"), 1))
                    2 -> graph.add(Edge(OdDo("b"), OdDo("c"), 1))
                    3 -> graph.add(Edge(OdDo("b"), OdDo("d"), 1))
                    4 -> graph.add(Edge(OdDo("b"), OdDo("e"), 1))
                }
                2 -> when (sAppend.selectedItemPosition) {
                    0 -> graph.add(Edge(OdDo("c"), OdDo("a"), 1))
                    1 -> graph.add(Edge(OdDo("c"), OdDo("b"), 1))
                    2 -> graph.add(Edge(OdDo("c"), OdDo("c"), 1))
                    3 -> graph.add(Edge(OdDo("c"), OdDo("d"), 1))
                    4 -> graph.add(Edge(OdDo("c"), OdDo("e"), 1))
                }
                3 -> when (sAppend.selectedItemPosition) {
                    0 -> graph.add(Edge(OdDo("d"), OdDo("a"), 1))
                    1 -> graph.add(Edge(OdDo("d"), OdDo("b"), 1))
                    2 -> graph.add(Edge(OdDo("d"), OdDo("c"), 1))
                    3 -> graph.add(Edge(OdDo("d"), OdDo("d"), 1))
                    4 -> graph.add(Edge(OdDo("d"), OdDo("e"), 1))
                }
                4 -> when (sAppend.selectedItemPosition) {
                    0 -> graph.add(Edge(OdDo("e"), OdDo("a"), 1))
                    1 -> graph.add(Edge(OdDo("e"), OdDo("b"), 1))
                    2 -> graph.add(Edge(OdDo("e"), OdDo("c"), 1))
                    3 -> graph.add(Edge(OdDo("e"), OdDo("d"), 1))
                    4 -> graph.add(Edge(OdDo("e"), OdDo("e"), 1))
                }


            }
        }
        btnDijsktra.setOnClickListener {
            val result = findShortestPath(graph,OdDo("a"),OdDo("e"))
            val shortestPath = result.shortestPath()
            txt.text = shortestPath.toString();
        }
    }
}





