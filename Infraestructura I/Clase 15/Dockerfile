FROM ubuntu
MAINTAINER Roberto Torfe "robertotorfe@gmail.com"

RUN apt-get update
RUN apt-get install -y apache2
RUN apt-get clean
RUN rm -rf /var/lib/apt/lists/*

EXPOSE 80

ENTRYPOINT ["/usr/sbin/apache2ctl", "-D", "FOREGROUND"]