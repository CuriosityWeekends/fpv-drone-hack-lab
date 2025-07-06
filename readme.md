# 🛸 FPV Drone Signal Reverse Engineering Lab

An advanced research project to decode and control undocumented FPV drones using WiFi-based UDP packet reverse engineering.  
**No SDKs. No APIs. Just raw data, smart observation, and Python.**

---

[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Python](https://img.shields.io/badge/python-3.9%2B-yellow.svg)](https://www.python.org/)
[![Built with Wireshark](https://img.shields.io/badge/tool-Wireshark-007ACC.svg)](https://www.wireshark.org/)
[![Status](https://img.shields.io/badge/status-in%20active%20development-orange)]()

---

## 📡 Overview

This repository is a reverse engineering sandbox for a toy FPV drone that lost its remote. By capturing the communication between the official mobile app and the drone over WiFi, we isolated individual payloads and recreated control using a custom-built Python UDP script.

> All testing was done blind, with no access to the drone’s source code, APIs, or official documentation. Every feature you see here was discovered manually — one packet at a time.

---

## 🔍 Project Highlights

| Feature | Description |
|--------|-------------|
| 🚀 Drone Takeoff | Fully working takeoff command replicated via PC |
| 🎮 Payload Mapping | Reverse engineered each action (takeoff, throttle, yaw...) |
| 🧠 PCAP Reverse Engineering | Manual decoding of `.pcap` files with Wireshark |
| 🧪 Payload Test Harness | Python script to loop/send payloads in milliseconds |
| 🖥️ Planned WASD Control | Full keyboard control (W, A, S, D + Space) in progress |

---

## 📁 Repository Structure

```bash
.
├── scripts/                  # Python tools to inject UDP packets
│   ├── drone_blast_loop.py
│   └── single_payload_test.py
├── captures/                # PCAP and traffic data
│   └── RCFPVPro_takeoff.pcap
├── docs/                    # Research and story
│   ├── origin_story.md
│   ├── payload_analysis.md
│   └── research_logbook.md
├── README.md
├── LICENSE
└── .gitignore
```

**🛠 Tools Used**
Wireshark – for packet analysis

PCAPdroid – mobile traffic capture

Python 3.x – for UDP scripting

Socket programming – for payload delivery


**🚧 Current Capabilities**
✅ Takeoff using injected payload

✅ Drone fan/motor activation

🧪 Throttle experiments underway

🔧 Full directional control (WASD) in progress

🧠 Behavioral payload map being developed


**🧬 Future Milestones**
 Build GUI dashboard to send payloads

 Add WASD and Space key control with pynput

 Automate payload generation from PCAP files

 Export payload map in CSV for community use


**🧠 Origin Story**
Curious how this project came to life?
Check out the full story in docs/origin_story.md


**⚠️ Disclaimer**
This project is intended for educational and research purposes only.
Do not attempt to control or interfere with drones you do not own.
Respect local drone laws and fly responsibly.


**👤 Author**
Built with patience and packet-fu by
Harsharaj Shetty B
Founder @ SparkBee Technologies • Cybersecurity Tinkerer • Drone Hacker
wwww.hsbofficial.com
