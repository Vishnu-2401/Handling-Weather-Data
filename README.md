# Handling-Weather-Data
A Spring Boot + MongoDB application that ingests historical weather data from CSV and exposes REST APIs for querying and analytics.

* Java 17+
* Spring Boot
* Spring Data MongoDB
* OpenCSV
* MongoDB
* Maven

Base URL

http://localhost:8088/api/weather

API Endpoints
1. Upload CSV

Uploads and ingests the weather dataset into MongoDB.

**Endpoint**

```
POST /api/weather/upload
```

**Postman Setup**

* Method: POST
* Body → form-data
* Key: `file` (type: File)
* Value: upload CSV file

**Response**

```
CSV imported successfully
```
 2. Filter by Weather Condition

Retrieves weather data for a specific condition (case-insensitive).

**Endpoint**

```
GET /api/weather/condition/{conds}
```

**Example**

```
GET /api/weather/condition/smoke
```

**Notes**

* Case-insensitive
* Matches values like Smoke, Haze, etc.

---

 3. Weather Details by Month 

Returns weather condition, temperature, humidity, and pressure for a given month.

**Endpoint**

```
GET /api/weather/month?year=YYYY&month=MM
```

**Example**

```
GET /api/weather/month?year=1996&month=11
```

**Response Fields**

* conds
* tempm
* hum
* pressurem

---

4. Weather Details by Date

Returns weather summary for a specific date.

**Endpoint**
```
GET /api/weather/date?year=YYYY&month=MM&day=DD
```

**Example**

```
GET /api/weather/date?year=1996&month=11&day=01
```

**Response Fields**

* conds
* tempm
* hum
* pressurem

---

5. Monthly Temperature Statistics

Provides high, minimum, and median temperature for each month of a given year.

**Endpoint**

```
GET /api/weather/stats/2015
```


**Response**

```json
[
  {
    "month": 11,
    "max": 34.0,
    "min": 18.0,
    "median": 26.0
  }
]
```

 Testing Flow

1. Upload CSV
2. Condition filter
3. Month filter
4. Date filter
5. Temperature stats

---
Handling Weather Data — Spring Boot + MongoDB Implementation
