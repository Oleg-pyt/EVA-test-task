# EVA Test task

I have implemented a mini-store containing products (id, name, and description) in this repository.
When requesting GET on the link localhost:8080/shop/inject - you can inject random data into the database, after which you can get products according to a specific pattern:
localhost:8080:/shop/product?namefilter=[filter] - we will get a list of products according to this pattern.
