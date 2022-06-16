docker run --name int-cont-mysql -p 3306:3306 -e MYSQL_USER=int-cont-backend -e MYSQL_DATABASE=int-cont-backend -e MYSQL_PASSWORD=int-cont-backend -e MYSQL_ROOT_PASSWORD=int-cont-backend -d mysql:8
