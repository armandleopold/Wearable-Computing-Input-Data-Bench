These files contain sample data with ground truth for eating and drinking.
The devices used to collect these data are:
* Samsung Galaxy S5 Active
* Microsoft Band 2

Data were collected and stored in Apache Avro format. The data have also been translated to CSV format. The raw traces for the entire data collection trial are in archives avro-raw.zip and csv-raw.zip. The CSV data have been further post-processed to organize subsets of data in sub-folders corresponding to particular interval labels (e.g., eating and drinking from time t1 to t2). The label-specific sub-folders are in csv-segments.zip. Note also that EventLabel files within the IntervalLabel directories (i.e., labeled time segments) indicate specific events within the larger activity (e.g., fork at mouth while eating and drinking).