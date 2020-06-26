# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

*** Settings ***
Documentation       Test for Recon UI
Library             String
Library             BuiltIn
Resource            ../commonlib.robot
Test Timeout        5 minutes

*** Variables ***
${ENDPOINT_URL}       http://recon:9888

*** Test Cases ***
Check if Recon Web UI is up
    Run Keyword if      '${SECURITY_ENABLED}' == 'true'     Kinit HTTP user
    ${result} =         Execute                             curl -Ss --negotiate -u : ${ENDPOINT_URL}
                        Should contain      ${result}       Ozone Recon
