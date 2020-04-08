/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.hadoop.ozone.web.ozShell.volume;

import org.apache.hadoop.ozone.client.OzoneClient;
import org.apache.hadoop.ozone.client.OzoneVolume;
import org.apache.hadoop.ozone.web.ozShell.OzoneAddress;

import picocli.CommandLine.Command;

import java.io.IOException;

/**
 * Executes volume Info calls.
 */
@Command(name = "info",
    description = "returns information about a specific volume")
public class InfoVolumeHandler extends VolumeHandler {

  @Override
  protected void execute(OzoneClient client, OzoneAddress address)
      throws IOException {

    OzoneVolume vol = client.getObjectStore()
        .getVolume(address.getVolumeName());
    printObjectAsJson(vol);
  }

}
