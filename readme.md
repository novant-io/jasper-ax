# Japser AX

[jasper]: https://github.com/novant-io/jasper

An implemenation of the easy-to-use [Jasper][jasper] JSON API for Niagara AX.

Niagara 4 support coming soon!

---

**🚧 UNDER HEAVY CONSTRUCTION 🚧**

---

## Installation

To setup Jasper on your JACE:

 1. Install the `jasper.jar` module onto your system
 2. Open the `jasper` palette
 3. Drag the `JasperService` into your `Services` component
 4. Let the index build and Done! 🏁

## Points

    $ curl host/jasper/v1/points -u username:password

    {
      "size": 3,
      "points": [
        {
          "id":   "av.1b6b",
          "name": "SetpointTemp",
          "path": "/PxHome/Graphics/Campus/Building/Floor1/VavZoneC/SetpointTemp",
          "unit": "°F"
        },
        {
          "id":   "bv.1b75",
          "name": "Occupied",
          "path": "/PxHome/Graphics/Campus/Building/Floor1/VavZoneC/Occupied"
        },
        {
          "id":   "av.1b6d",
          "name": "HeatingCoil",
          "path": "/PxHome/Graphics/Campus/Building/Floor1/VavZoneC/HeatingCoil",
          "unit": "%"
        }
      ]
    }

## Values

    $ curl host/jasper/v1/values -u username:password

    {
      "size": 3,
      "values": [
        { "id":"h:1b6b", "val":72 },
        { "id":"h:1b75", "val":true },
        { "id":"h:1b6d", "val":25 }
      ]
    }
