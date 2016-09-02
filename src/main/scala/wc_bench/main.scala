package wc_bench

// Distributed Functionality
import org.apache.spark.{SparkConf, SparkContext}
import com.datastax.spark.connector._

// Local Functionality
import java.io.File
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by erandal on 7/25/16.
  */

object main {

  case class FoodToUserIndex(food: String, user: String)

  def main(args: Array[String]) {

      val dataIndex = new DataIndex("Sample Dataset/Driving-Transit/Driving Car/csv").index()

    val conf = new SparkConf(true)
      .set("spark.cassandra.connection.host", "127.0.0.1")
    val sc = new SparkContext("local", "test", conf)
    val user_table = sc.cassandraTable("tutorial", "user")
    val food_index = user_table.map(r => new FoodToUserIndex(r.getString("favorite_food"), r.getString("name")))

    food_index.saveToCassandra("tutorial", "food_to_user_index")
  }
}
