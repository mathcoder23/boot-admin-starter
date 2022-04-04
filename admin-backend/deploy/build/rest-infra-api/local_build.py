#!/usr/bin/python
import configparser
import os

_docker_image_name = "boot-admin-starter"

print('docker image name:' + _docker_image_name)


def buildImageTag():
    with open('pom.properties', 'r', encoding='utf-8') as f:
        content = "[default]\n" + f.read()
    con = configparser.ConfigParser()
    con.read_string(content)
    artifacId = con.get("default", 'artifactId')
    version = con.get("default", 'version')
    return "%s_%s" % (artifacId, version)


def main():
    version = buildImageTag()
    tag = _docker_image_name + ":" + version
    print('docker image tag:', tag)

    print('starting build docker image')
    os.system('docker build -t %s' % tag)
    print('finished docker image:', tag)


main()
