/**
 * Copyright 2013-2015, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 *
 * @providesModule sortTypeFirst
 * @typechecks
 * 
 */

'use strict';

var TYPE = '__type__';

function sortTypeFirst(a, b) {
  if (a === b) {
    return 0;
  }
  if (a === TYPE) {
    return -1;
  }
  if (b === TYPE) {
    return 1;
  }
  if (a < b) {
    return -1;
  }
  // a > b
  return 1;
}

module.exports = sortTypeFirst;