# COVID-19 Info Extraction DashBoard
Hosts a Jakarta REST API and logs data and metadata to Mongo DB.<br />
Also contains a dashboard that fetches the DB data and dispalys it to https://akshaysicmu.herokuapp.com/

## Installation
    1. Clone master
    2. If you're using Intellij/Eclipse, you should have your dependencies installed,
    3. **Not recommended:**  create a new Java enterprise application with Javakarta 9
    4. Run the app and you'll find the host info on the console log
    5. The API host info should be listed on the console, use a REST Client (Postman, ARC extension on Chrome, etc.) to retrieve filtered data
    6. Please refer to the code of the file to get more info about each component of the MVC layer

## Data Layer
  1. Cluster: https://cloud.mongodb.com/v2/61796628755bbc20eb16a6b6#clusters/detail/ClusterZipCode
  2. Install Maven dependencies for getting access, security info is listed on comments of the Model Layer

## Run
    1. Enter a valid age range
    2. For info on correct attributes, please check MIT's site
    3. The API should return a filtered out response to your request

## Citations
#### Thanks to help from MIT COVID-19 survey and their public APIs
<a id="1">[1]</a>
Collis, A., Garimella, K., Moehring, A., Rahimian, M.A., Babalola, S., Gobat, N., Shattuck, D.,  Stolow, J., Eckles, D., and Aral, S. (2020). Global survey on COVID-19 beliefs, behaviors, and norms. Technical report, MIT Sloan School of Management
