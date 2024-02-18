FROM docker.elastic.co/beats/filebeat:7.14.0
USER root
RUN chmod go-w filebeat.yml
COPY filebeat.yml /usr/share/filebeat/filebeat.yml
RUN mkdir /var/log/server
RUN chown root:filebeat /usr/share/filebeat/filebeat.yml
USER filebeat
