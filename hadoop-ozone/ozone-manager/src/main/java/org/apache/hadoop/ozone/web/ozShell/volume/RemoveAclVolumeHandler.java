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
import org.apache.hadoop.ozone.security.acl.OzoneObj;
import org.apache.hadoop.ozone.web.ozShell.OzoneAddress;
import org.apache.hadoop.ozone.web.ozShell.acl.AclHandler;
import org.apache.hadoop.ozone.web.ozShell.acl.AclOption;
import picocli.CommandLine;

import java.io.IOException;

/**
 * Remove ACL from volume.
 */
@CommandLine.Command(name = AclHandler.REMOVE_ACL_NAME,
    description = AclHandler.REMOVE_ACL_DESC)
public class RemoveAclVolumeHandler extends AclHandler {

  @CommandLine.Mixin
  private VolumeUri address;

  @CommandLine.Mixin
  private AclOption acls;

  @Override
  protected OzoneAddress getAddress() {
    return address.getValue();
  }

  @Override
  protected void execute(OzoneClient client, OzoneObj obj) throws IOException {
    acls.removeFrom(obj, client.getObjectStore(), out());
  }

}
