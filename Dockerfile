FROM alpine
RUN apk add openjdk8
ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/bin
WORKDIR /usr/share/practice
ADD Test.java Test.java
ENTRYPOINT javac Test.java && java Test $NUMBER