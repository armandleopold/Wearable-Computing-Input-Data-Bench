package wc_bench

/**
  * Created by erandal on 7/26/16.
  */

import java.io.File
import scala.collection.mutable.ListBuffer
import scala.io.Source

class DataIndex(rootDir:String) {

  println("****************** Indexer *******************")

  def getListOfDir(dir: String):List[File] = {

    val d = new File(dir)

    if (d.exists) {
      d.listFiles.filter(_.isDirectory).toList
    } else {
      List[File]()
    }
  }

  def getListOfFiles(dir: String):List[File] = {

    val d = new File(dir)

    if (d.exists) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  def printList(args: List[_]): Unit = {
    args.foreach(println)
  }

  def index():List[List[String]] = {

    //Benchmark
    val start = System.nanoTime()

    // Set the root directory of the indexer

    // none variables
    val branchId = 0
    var nbrLine = 0

    // Printer
    println("\n => Level " + rootDir.toString.split("/").length + " // Branch id = " + branchId + " // FOLDERS ")
    val listDir = getListOfDir(rootDir)
    printList(listDir)
    println("\n => Level " + rootDir.toString.split("/").length + " // Branch id = " + branchId + " // FILES ")
    val listFiles = getListOfFiles(rootDir)
    printList(listFiles)

    var fileIndex = new ListBuffer[List[String]]
    var nbrFile = 0
    // Converting into list of files
    for (elem <- listFiles){

      println("--> File id : "+nbrFile)
      val replaced = elem.toString.replaceAll(rootDir+"/0_","")
      val splited = replaced.split("-")

      //Aggregation of the data
      val temp_list = List(splited(0), rootDir + "/0_" + splited(0) + "-" + splited(1))

      println("Input Type : " + temp_list.head)
      println("PATH : "+temp_list(1))

      for (line <- Source.fromFile(elem).getLines()) {
        nbrLine += 1
      }

      nbrFile +=1
      // adding the file metadata to the list of files
      fileIndex += temp_list
    }

    println("\nNombre de fichiers :"+nbrFile)
    println("Nombre de lignes lues :"+nbrLine)

    val end = System.nanoTime()
    println("****************************************************")
    println("==> Elapsed time : "+(end-start)/1000000+","+(end-start)/1000+" ms")
    val fileIndex2 = fileIndex.toList

    fileIndex2
  }
}